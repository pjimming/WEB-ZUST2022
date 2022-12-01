<template>
    <div v-for="post in posts.posts" :key="post.id">
        <div class="card article-card">
        <div class="card-header">
            {{ post.name }}
        </div>
        <div class="card-body">
            <blockquote class="blockquote mb-0">
            <p>{{ post.content }}</p>
            <footer class="blockquote-footer">发布于 <cite title="Source Title">{{ post.time }}</cite></footer>
            </blockquote>
        </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'ArticleArea',
    props: {
        posts: {
            type: Object,
            required: true,
        }
    }
}
</script>

<style scoped>
.article-card {
    margin-top: 20px;
}
</style>