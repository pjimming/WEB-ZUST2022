<template>
    <ContentBase>
    <RegisterCom></RegisterCom>
    </ContentBase>
  </template>
  
  <script>
  // @ is an alias to /src
  import ContentBase from '../components/ContentBase'
  import RegisterCom from '@/components/RegisterCom.vue';
  
  export default {
    name: "RegisterView",
    components: {
      ContentBase,
      RegisterCom,
    }
  }
  </script>
  
  <style scoped>
  </style>