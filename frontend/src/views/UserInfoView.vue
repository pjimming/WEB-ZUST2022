<template>
    <ContentBase>
      <div class="row">
        <div class="col-12">
          <p>发布过的动态</p>
          <div v-for="bot in bots.reverse()" :key="bot.id">
          <div class="card article-card">
            <div class="card-header">
                {{ bot.username }}
                <button type="button" class="btn btn-success float-end" @click="remove_bot(bot)">删除</button>
            </div>
            <div class="card-body">
                <blockquote class="blockquote mb-0">
                <p>{{ bot.content }}</p>
                <footer class="blockquote-footer">发布于 <cite title="Source Title">{{ bot.createtime }}</cite></footer>
                </blockquote>
            </div>
          </div>
        </div>
        </div>
      </div>
    </ContentBase>
  </template>
  
<script>
// @ is an alias to /src
import ContentBase from '../components/ContentBase'
import { ref } from 'vue'
import $ from 'jquery'
import { useStore } from 'vuex'

export default {
  name: "UserInfoView",
  components: {
    ContentBase,
  },

  setup() {
    let bots = ref([]);
    const store = useStore();
    const refresh_bots = () => {
        $.ajax({
            url: "http://127.0.0.1:3000/user/bot/getlist/",
            type: "get",
            headers: {
                Authorization: "Bearer " + store.state.user.token,
            },
            success(resp) {
                bots.value = resp;
            }
        })
    }

    const remove_bot = (bot) => {
        $.ajax({
            url: "http://127.0.0.1:3000/user/bot/remove/",
            type: "post",
            data: {
                id: bot.id,
            },
            headers: {
                Authorization: "Bearer " + store.state.user.token,
            },
            success(resp) {
                if (resp.error_message === "success") {
                    refresh_bots();
                }
            }
        })
    }

    refresh_bots();
    return {
      bots,
      remove_bot,
    }
  }
  }
</script>

<style scoped>
.article-card {
    margin-top: 20px;
}
</style>