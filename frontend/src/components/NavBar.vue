<template>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
    <router-link class="navbar-brand" :to="{name: 'home'}">和山论坛</router-link>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <router-link class="nav-link" :to="{name: 'home'}">首页</router-link>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    PJM
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{name: 'userinfo'}">个人主页</router-link>
                    </li>
                    <li><hr class="dropdown-divider"></li>
                    <li><router-link class="dropdown-item" :to="{name: 'user_account_login'}">退出</router-link></li>
                </ul>
            </li>
        </ul>

    </div>
    </div>
</nav>
</template>
    
    
<script>
export default {
    name: "NavBar",
}
</script>

<style scoped>

</style>
    