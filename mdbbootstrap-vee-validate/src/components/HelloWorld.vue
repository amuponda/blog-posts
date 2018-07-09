<template>
  <container>
    <form @submit.prevent="login">
      <p class="h4 text-center mb-4">Sign in</p>
      <div class="grey-text">
        <md-input
          v-validate="'required|email'"
          name="email"
          label="Email"
          icon="envelope"
          type="text"
          :value="email"
          @input="email = $event">
          <p v-show="errors.has('email')" class="text-danger"><small>{{ errors.first('email') }}</small></p>
        </md-input>
      </div>
      <button type="submit">Test</button>
    </form>
  </container>
</template>

<script>
import MdInput from 'mdbvue/src/components/MdInput'
import Container from 'mdbvue/src/components/Container'

export default {
  name: 'HelloWorld',
  components: {MdInput, Container},
  data () {
    return {
      email: ''
    }
  },
  methods: {
    login () {
      this.$validator.validateAll().then(result => {
        if (result) {
          alert("Email is: " + this.email)
        }
      })
    }
  }
}
</script>


</style>
