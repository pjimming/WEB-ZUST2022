<template>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
    <router-link class="navbar-brand" :to="{name: 'home'}">和山论坛</router-link>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <router-link class="nav-link" :to="{name: 'home'}">首页</router-link>
            </li>
            <li class="nav-item">
                <router-link class="nav-link" :to="{name: 'ranklist_index'}">用户</router-link>
            </li>
        </ul>
        <ul class="navbar-nav" v-if="$store.state.user.is_login">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    PJM
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{name: 'userinfo'}">个人主页</router-link>
                    </li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="http://localhost:8080/user/account/login/" @click="logout">退出</a></li>
                </ul>
            </li>
        </ul>

    </div>
    </div>
</nav>
</template>
    
    
<script>
import { useRoute } from 'vue-router'
import { computed } from 'vue'
import { useStore } from 'vuex';


export default {
    name: "NavBar",
    setup() {
        const store = useStore();
        const route = useRoute();
        let route_name = computed(() => route.name)

        const logout = () => {
          store.dispatch("logout");
        }

        return {
            route_name,
            logout
        }
    }

}
</script>

<style scoped>

</style>
    