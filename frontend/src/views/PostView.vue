<template>
    <ContentBase>
      <div class="form-floating">
        <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 600px"></textarea>
        <label for="floatingTextarea2">你想说...</label>
      </div>
      <br />
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button class="btn me-md-2 btn-outline-primary" type="button">发布</button>
      </div>
    </ContentBase>
  </template>
  
  <script>
  // @ is an alias to /src
  import ContentBase from '../components/ContentBase'
  
  export default {
    name: "PostView",
    components: {
      ContentBase,
    }
  }
  </script>
  
  <style scoped>
  </style>