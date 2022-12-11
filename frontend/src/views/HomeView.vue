<template>
  <ContentBase>
    <div class="text-center">欢迎 PJM 同学</div>
    <br>
    <div class="input-group mb-3">
      <input v-model="botadd.content" type="text" class="form-control" placeholder="今天你过得怎么样…" aria-label="Recipient's username" aria-describedby="button-addon2">
      <button class="btn btn-outline-secondary" type="button" id="button-addon2" @click="add_bot">发布</button>
    </div>
    <hr>
  </ContentBase>
</template>

<script>
// @ is an alias to /src
import ContentBase from '../components/ContentBase'
import { reactive } from 'vue';
import { useStore } from 'vuex'
import $ from 'jquery'

export default {
  name: "HomeView",
  components: {
    ContentBase,
  },

  setup() {
    const store = useStore();
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
                } else {
                    botadd.error_message = resp.error_message;
                }
            }
        })
    }
    return {
      add_bot,
      botadd,
    }
  },

}
</script>

<style scoped>
</style>