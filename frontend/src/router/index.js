import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue';
import ArticleView from '../views/ArticleView.vue';
import LoginView from '../views/LoginView.vue';
import PostView from '../views/PostView.vue';
import RegisterView from '../views/RegisterView.vue';
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
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/post',
    name: 'post',
    component: PostView
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView
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
