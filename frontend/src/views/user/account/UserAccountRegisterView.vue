<template>
    <ContentBase>
    <form @submit.prevent="register">
    <h1 class="text-center">和山论坛</h1>
    <p class="text-center">属于每个ZUSTer的和山论坛</p>
    <hr>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">用户名：</label>
        <input v-model="username" type="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">密码：</label>
        <input v-model="password" type="password" class="form-control" id="exampleInputPassword1">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">确认密码：</label>
        <input v-model="confirmedPassword" type="password" class="form-control" id="exampleInputPassword1">
    </div>
    <div class="error-message">{{ error_message }}</div>
    <a href="/user/account/login/">已有账号，点击登录！</a>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button class="btn btn-primary" type="submit">注册</button>
    </div>
    </form>
    </ContentBase>
</template>

<script>
import ContentBase from '@/components/ContentBase.vue';
import { ref } from 'vue';
import router from '../../../router/index';
import $ from 'jquery';

export default {
    components: {
        ContentBase,
    },
    setup() {
        let username = ref("");
        let password = ref("");
        let confirmedPassword = ref("");
        let error_message = ref("");

        const register = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/user/account/register/",
                type: "post",
                data: {
                    username: username.value,
                    password: password.value,
                    confirmedPassword: confirmedPassword.value,
                },
                success(resp) {
                    if(resp.error_message == "success") {
                        router.push({name: "user_account_login"});
                    } else {
                        error_message.value = resp.error_message;
                    }
                },
            })
        }
        return {
            username,
            password,
            confirmedPassword,
            error_message,
            register, 
        }
    }
}
</script>

<style scoped>
button {
    width: 100%;
}

div.error-message {
    color: red;
}
</style>
