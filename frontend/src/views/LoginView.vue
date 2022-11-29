<template>
    <ContentBase>
    <LoginCom></LoginCom>
    </ContentBase>
  </template>
  
  <script>
  // @ is an alias to /src
  import ContentBase from '../components/ContentBase'
  import LoginCom from '@/components/LoginCom.vue';
  
  export default {
    name: "LoginView",
    components: {
      ContentBase,
      LoginCom,
    }
  }
  </script>
  
  <style scoped>
  </style>