<template>
    <div class="article-card">
    <div class="card">
    <div class="card-header">
        PJM
    </div>
    <div class="card-body">
        <blockquote class="blockquote mb-0">
        <p>今天过得很开心！</p>
        <footer class="blockquote-footer">发布于 <cite title="Source Title">16点17分</cite></footer>
        </blockquote>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="button" class="btn btn-danger">删除</button>
    </div>
    </div>
    </div>
    </div>
</template>

<script>
export default {
    name: 'UserPost',
}
</script>

<style scoped>
.article-card {
    margin-top: 20px;
}
</style>