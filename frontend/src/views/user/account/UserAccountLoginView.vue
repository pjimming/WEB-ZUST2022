<template>
    <ContentBase v-if="!$store.state.user.pulling_info">
      <form @submit.prevent="login">
        <h1 class="text-center">和山论坛</h1>
        <p class="text-center">属于每个ZUSTer的和山论坛</p>
        <hr>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">用户名：</label>
            <input v-model="username" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">密码：</label>
            <input v-model="password" type="password" class="form-control" id="exampleInputPassword1">
        </div>
        <div class="error-message">{{ error_message }}</div>
        <a href="/user/account/register/">还没有账号？点击注册！</a>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button class="btn btn-primary" type="submit">登录</button>
        </div>
      </form>
    </ContentBase>
</template>

<script>
import ContentBase from '@/components/ContentBase.vue'
import { useStore } from 'vuex'
import { ref } from 'vue'
import router from '../../../router/index'

export default {
    components: {
        ContentBase
    },
    setup() {
        const store = useStore();
        let username = ref('');
        let password = ref('');
        let error_message = ref('');

        const jwt_token = localStorage.getItem("jwt_token");
        if (jwt_token) {
            store.commit("updateToken", jwt_token);
            store.dispatch("getinfo", {
                success() {
                    router.push({name: "home"});
                    store.commit("updatePullingInfo", false);
                },
                error() {
                    store.commit("updatePullingInfo", false);
                }
            })
        } else {
            store.commit("updatePullingInfo", false);
        }


        const login = () => {
            error_message.value = "";
            store.dispatch("login", {
                username: username.value,
                password: password.value,
                success() {
                    store.dispatch("getinfo", {
                        success() {
                            router.push({ name: 'home' });
                        }
                    })
                },
                error() {
                    error_message.value = "用户名或密码错误";
                }
            })
        }

        return {
            username,
            password,
            error_message,
            login,
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
