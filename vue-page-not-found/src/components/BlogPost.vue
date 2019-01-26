<template>
    <div>
        <h3>{{post.title}}</h3>
        <p>{{post.excerpt}}</p>
    </div>
</template>

<script>
import router from '../router'

const posts = [
    { id: 1, title: 'First One', excerpt: 'A blog post with nothing' },
    { id: 2, title: 'Another One', excerpt: 'Another post about nothing' },
]

export default {
  name: 'BlogPost',
  data () {
    return {
       post: {}
    }
  },
  beforeRouteEnter(to, from, next) {
      let selected = posts.find(post => post.id === to.params.id)
      if (selected) {
          next(vm => {
              vm.post = selected
          })
      } else {
          router.push({ name: 'notFound', params: { '0': to.path } })
      }
  },
  beforeRouteUpdate(to, from, next) {
    let post = posts.find(post => post.id === to.params.id)
    if (post) {
        this.post = post
        next()
    } else {
        router.push({ name: 'notFound', params: { '0': to.path } })
    }
  }
}
</script>

<style scoped>

</style>