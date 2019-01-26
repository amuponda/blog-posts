<template>
    <div>
        <h1>This is the blog page</h1>
        <ul>
            <li><router-link :to="{ name: 'blogPost',  params: {id: 1} }">Post 1</router-link></li>
            <li><router-link :to="{ name: 'blogPost',  params: {id: 2} }">Post 2</router-link></li>
            <li><router-link :to="{ name: 'blogPost',  params: {id: 3} }">Post 3</router-link></li>
        </ul>
        <p>FYI, blog post three does not exist</p>
        <router-view/>
    </div>
</template>

<script>
export default {
  name: 'Blog'
}
</script>

<style scoped>

</style>