<template>
  <ContentBase>
    <div class="text-center">欢迎 {{now_username}} 同学</div>
    <br>
    <div class="input-group mb-3">
      <input v-model="botadd.content" type="text" class="form-control" placeholder="今天你过得怎么样…" aria-label="Recipient's username" aria-describedby="button-addon2">
      <button class="btn btn-outline-secondary" type="button" id="button-addon2" @click="add_bot">发布</button>
    </div>
    <hr>
    <div v-for="post in records" :key="post.bot.id">
        <div class="card article-card">
        <div class="card-header">
            {{ post.bot.username }}
        </div>
        <div class="card-body">
            <blockquote class="blockquote mb-0">
            <p>{{ post.bot.content }}</p>
            <footer class="blockquote-footer">发布于 <cite title="Source Title">{{ post.bot.createtime }}</cite></footer>
            </blockquote>
        </div>
        </div>
    </div>
    <hr>
    <nav aria-label="...">
      <ul class="pagination" style="float: right;">
          <li class="page-item" @click="click_page(-2)">
              <a class="page-link" href="#">前一页</a>
          </li>
          <li :class="'page-item ' + page.is_active" v-for="page in pages" :key="page.number" @click="click_page(page.number)">
              <a class="page-link" href="#">{{ page.number }}</a>
          </li>
          <li class="page-item" @click="click_page(-1)">
              <a class="page-link" href="#">后一页</a>
          </li>
      </ul>
    </nav>
  </ContentBase>
</template>

<script>
// @ is an alias to /src
import ContentBase from '../components/ContentBase'
import { ref, reactive } from 'vue';
import { useStore } from 'vuex'
import $ from 'jquery'

export default {
  name: "HomeView",
  components: {
    ContentBase,
  },

  setup() {
    let current_page = 1;
    let records = ref([]);
    let total_records = 0;
    let pages = ref([]);

    const update_pages = () => {
      let max_pages = parseInt(Math.ceil(total_records / 4));
      let new_pages = [];
      for(let i = current_page - 2; i <= current_page + 2; i ++ ) {
        if(i >= 1 && i <= max_pages) {
          new_pages.push({
            number: i,
            is_active: i === current_page ? "active" : "",
          });
        }
      }
      pages.value = new_pages;
    }

    const click_page = page => {
      if(page === -2) page = current_page - 1;
      else if(page === -1) page = current_page + 1;
      let max_pages = parseInt(Math.ceil(total_records / 4));
      if(page >= 1 && page <= max_pages) {
        pull_page(page);
      }
    }
    const store = useStore();
    let now_username = store.state.user.username;

    const botadd = reactive({
        content: "",
        error_message: "",
    });

    const add_bot = () => {
        botadd.error_message = "";
        $.ajax({
            url: "http://127.0.0.1:3000/user/bot/add/",
            type: "post",
            data: {
                content: botadd.content,
            },
            headers: {
                Authorization: "Bearer " + store.state.user.token,
            },
            success(resp) {
                if (resp.error_message === "success") {
                    botadd.content = "";
                    pull_page(current_page);   
                } else {
                    botadd.error_message = resp.error_message;
                }
            }
        })
    }

    const pull_page = page => {
      current_page = page;
      $.ajax({
          url: "http://127.0.0.1:3000/record/getlist/",
          type: "get",
          data: {
            page,
          },
          headers: {
              Authorization: "Bearer " + store.state.user.token,
          },
          success(resp) {
              records.value = resp.records;
              total_records = resp.records_count;
              update_pages();
          },
          error(resp) {
            console.log(resp);
          }
      })
    }
    
    pull_page(current_page);
    
    return {
      add_bot,
      botadd,
      records,
      pages,
      click_page,
      now_username,
    }
  },

}
</script>

<style scoped>
.article-card {
    margin-top: 20px;
}
</style>