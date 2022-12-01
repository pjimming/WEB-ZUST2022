<template>
    <form>
    <h1 class="text-center">和山论坛</h1>
    <p class="text-center">属于每个ZUSTer的和山论坛</p>
    <hr>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">学号：</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">密码：</label>
        <input type="password" class="form-control" id="exampleInputPassword1">
    </div>
    <a href="/register">还没有账号？点击注册！</a>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
    <button class="btn btn-primary" type="button">登录</button>
    </div>
    </form>
</template>

<script>
export default {
    name: 'LoginCom',
}
</script>


<style scoped></style>