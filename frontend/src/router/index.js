import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue';
import ArticleView from '../views/ArticleView.vue';
import PostView from '../views/PostView.vue';
import UserAccountLoginView from '../views/user/account/UserAccountLoginView'
import UserAccountRegisterView from '../views/user/account/UserAccountRegisterView'
import UserInfoView from '../views/UserInfoView.vue';
import store from '../store/index';
import UserBotIndexView from '../views/user/bot/UserBotIndexView';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: '/article',
    name: 'article',
    component: ArticleView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/user/account/login/",
    name: "user_account_login",
    component: UserAccountLoginView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: '/post/',
    name: 'post',
    component: PostView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/user/bot/",
    name: "user_bot_index",
    component: UserBotIndexView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/user/account/register/",
    name: "user_account_register",
    component: UserAccountRegisterView,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: '/userinfo/',
    name: 'userinfo',
    component: UserInfoView,
    meta: {
      requestAuth: true,
    }
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  if (to.meta.requestAuth && !store.state.user.is_login) {
    next({name: "user_account_login"});
  } else {
    next();
  }
})

export default router
