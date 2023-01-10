<template>
    <div class="center">
  <main>
    <h1 class="title">Words Counter</h1>

    <form class="textForm">
      <textarea
        name="text"
        id="text"
        class="textbox"
        cols="50"
        rows="10"
        v-model="text"
        placeholder="Put a text to find out the number of words"
        @input="onInputText()"
      ></textarea>
    </form>

    <section
      class="result"
      v-if="wordsCount > 0 || wordsCount == 'Text too long!'"
    >
      {{ wordsCount }} <span v-if="wordsCount == 1">word</span>
      <span v-if="wordsCount > 1">words</span>
    </section>
  </main>
    </div>
</template>

<script>
import axios from "axios";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "Form",
  data: () => ({
    text: "",
    wordsCount: 0,
    timer: Function,
  }),
  methods: {
    onInputText() {
      clearTimeout(this.timer)
      this.timer = setTimeout( async () => {
        if (this.text.length > 1000) {
          this.wordsCount = "Text too long!";
        } else {
          let wordsCount = await axios.post(`${SERVER_URL}/count`, {
            content: this.text,
          });

          this.wordsCount = wordsCount.data;
        }
      }, 1000)
    },
  },
};
</script>

<style scoped>
.center{
  display: block;
  text-align: center;
}
main {
  display: inline-block;
    margin-left: auto;
    margin-right: auto;
    text-align: left;

}
.title {
  font-size: 5ch;
}
.textbox {
  border-radius: 2%;
  border-style: solid;
  border-color: #00c5e1;
  border-width: 0.2em;
  width: 40vw;
  max-width: 800px;
  height: 40vh;
  max-height: 800px;
  font-size: 2ch;
  transition-duration: 200ms;
}

.textbox:focus {
  outline: none;
  border-width: 0.25em;
}
.result {
  font-size: 3.5ch;
  margin-top: 0.5em;
}
</style>
