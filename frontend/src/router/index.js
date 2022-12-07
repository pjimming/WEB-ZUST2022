import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue';
import ArticleView from '../views/ArticleView.vue';
// import LoginView from '../views/LoginView.vue';
import PostView from '../views/PostView.vue';
// import RegisterView from '../views/RegisterView.vue';
import UserAccountLoginView from '../views/user/account/UserAccountLoginView'
import UserAccountRegisterView from '../views/user/account/UserAccountRegisterView'

import UserInfoView from '../views/UserInfoView.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/article',
    name: 'article',
    component: ArticleView
  },
  // {
  //   path: '/user/account/login',
  //   name: 'login',
  //   component: LoginView
  // },
  {
    path: "/user/account/login/",
    name: "user_account_login",
    component: UserAccountLoginView,
  },
  {
    path: '/post',
    name: 'post',
    component: PostView
  },
  // {
  //   path: '/user/account/register',
  //   name: 'register',
  //   component: RegisterView
  // },
  {
    path: "/user/account/register/",
    name: "user_account_register",
    component: UserAccountRegisterView,
  },
  {
    path: '/userinfo',
    name: 'userinfo',
    component: UserInfoView
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
