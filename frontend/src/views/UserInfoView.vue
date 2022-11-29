<template>
    <ContentBase>
      <div class="row">
        <div class="col-3">
          <UserInfoCom />
        </div>
        <div class="col-9">
          <p>发布过的动态</p>
          <UserPost />
          <UserPost />
          <UserPost />
        </div>
      </div>
    </ContentBase>
  </template>
  
  <script>
  // @ is an alias to /src
  import ContentBase from '../components/ContentBase'
  import UserInfoCom from '@/components/UserInfoCom.vue'
  import UserPost from '@/components/UserPost.vue'
  
  export default {
    name: "UserInfoView",
    components: {
      ContentBase,
      UserInfoCom,
      UserPost,
    }
  }
  </script>
  
  <style scoped>
  </style>