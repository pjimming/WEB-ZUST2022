<template>
  <ContentBase>
    <div class="text-center">欢迎 PJM 同学</div>
    <br>
    <TextArea></TextArea>
    <hr>
    <ArticleArea :posts="posts" />
  </ContentBase>
</template>

<script>
// @ is an alias to /src
import ContentBase from '../components/ContentBase'
import TextArea from '../components/TextArea.vue';
import ArticleArea from '@/components/ArticleArea.vue';
import { reactive } from 'vue';

export default {
  name: "HomeView",
  components: {
    ContentBase,
    TextArea,
    ArticleArea,
  },

  setup() {
    const posts = reactive({
      count: 3,
      posts: [
        {
          id: 1,
          Userid: 1200696021,
          name: "PJM",
          content: "今天过得很开心",
          time: "13点37分"
        },
        {
          id: 2,
          Userid: 1200696021,
          name: "PJM",
          content: "今天下雪了",
          time: "13点38分"
        },
        {
          id: 1,
          Userid: 1200696021,
          name: "PJM",
          content: "今天做核酸了",
          time: "13点39分"
        },
      ]
    });

    return {
      posts,
    }
  },

}
</script>

<style scoped>
</style>