<template>
  <div >
  <!-- <emp-view>
    
  </emp-view> -->
<router-view></router-view>
  </div>
</template>

<script>
// import EmpView from './tlias/EmpView.vue'

export default {
   components: { /*EmpView*/ },
    data(){
      return{
        message:"Hello vue"
      }
    },
    methods:{

    }
  }
</script>

<style>

</style>
