<template>
  <ContentBase>
    <div class="text-center">欢迎 PJM 同学</div>
    <br>
    <TextArea></TextArea>
    <hr>
    <ArticleArea />
    <ArticleArea />
    <ArticleArea />
  </ContentBase>
</template>

<script>
// @ is an alias to /src
import ContentBase from '../components/ContentBase'
import TextArea from '../components/TextArea.vue';
import ArticleArea from '@/components/ArticleArea.vue';

export default {
  name: "HomeView",
  components: {
    ContentBase,
    TextArea,
    ArticleArea,
  }
}
</script>

<style scoped>
</style>