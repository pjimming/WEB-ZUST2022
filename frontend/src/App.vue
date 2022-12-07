<template>
  <NavBar />
  <router-view/>
</template>

<script >
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap'
import NavBar from './components/NavBar.vue'
// import $ from 'jquery'

export default {
  name: "App",
  components: {
    NavBar,
  },
  
  setup() {
  //   $.ajax({
  //     url: "http://localhost:3000/user/account/token/",
  //     type: "post",
  //     data: {
  //       username: "fyq",
  //       password: "p1",
  //     },
  //     success(resp) {
  //       console.log(resp);
  //     },
  //     error(resp) {
  //       console.log(resp);
  //     }
  //   })

  //   $.ajax({
  //     url: "http://localhost:3000/user/account/info/",
  //     type: "get",
  //     headers: {
  //       Authorization: "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjMDU4OWRkN2FiMmQ0Nzg3ODdjN2MzYmMzMTVhYmU5ZiIsInN1YiI6IjIiLCJpc3MiOiJzZyIsImlhdCI6MTY3MDM0MDQ3NSwiZXhwIjoxNjcxNTUwMDc1fQ.Ld_L1bTpFETgSeq0IpzWwAIIzvaWLPR0zcmerCThTJ0",
  //     },
  //     success(resp) {
  //       console.log(resp);
  //     },
  //     error(resp) {
  //       console.log(resp);
  //     }
  //   })

  //   $.ajax({
  //     url: "http://localhost:3000/user/account/register/",
  //     type: "post",
  //     data: {
  //       username: "fyq2",
  //       password: "123",
  //       confirmedPassword: "123",
  //     },
  //     success(resp) {
  //       console.log(resp);
  //     },
  //     error(resp) {
  //       console.log(resp);
  //     }     
  //   })
  }

}

</script>

<style>
body {
  background-image: url('./assets/background.jpg');
  background-size: cover;
}
</style>
