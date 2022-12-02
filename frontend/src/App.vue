<template>
  <div>昵称：{{bot_name}}</div>
  <div>级别：{{bot_rating}}</div>
  <NavBar />
  <router-view/>
</template>

<script >
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap'
import NavBar from './components/NavBar.vue'
import $ from 'jquery'
import { ref } from 'vue'

export default {
  name: "App",
  components: {
    NavBar,
  },
  setup: () => {
    let bot_name = ref("");
    let bot_rating = ref("");

    $.ajax({
      url: "http://localhost:3000/pk/getbotinfo/",
      type: "get",
      success: resp => {
        console.log(resp);
      }
    });

    return {
      bot_name,
      bot_rating
    }
  }

}

</script>

<style>
body {
  background-image: url('./assets/background.jpg');
  background-size: cover;
}
</style>
