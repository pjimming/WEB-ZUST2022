<template>
    <ContentBase>
        我的Bot
    </ContentBase>
</template>

<script>
import ContentBase from '@/components/ContentBase.vue';
import $ from 'jquery'
import { useStore } from 'vuex'

export default {
    components: {
        ContentBase,
    },
    setup() {
        const store = useStore();
        $.ajax({
            url: "http://127.0.0.1:3000/user/bot/add/",
            type: "POST",
            data: {
                content: "Bot的代码",
            },
            headers: {
                Authorization: "Bearer " + store.state.user.token,
            },
            success(resp) {
                console.log(resp);
            },
            error(resp) {
                console.log(resp);
            }
        })
    }
}
</script>

<style scoped>
</style>
