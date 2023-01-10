<template>
  <router-view />
  <footer><h1>Made by Lissa Ferreira @ 2023</h1></footer>
</template>

<style>
@import url("https://fonts.googleapis.com/css2?family=Sofia+Sans:ital,wght@0,300;0,400;0,700;1,300;1,400;1,700&display=swap");
body {
  background-color: white;
  font-family: "Sofia Sans", sans-serif;
  height: 100vh;
}
p,
h1 {
  color: #302d68;
}
h2 {
  color: #333;
}
footer{
  background-color: #302d68;
  margin-top: 60vh;
  position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
}
footer > h1{
  color: white;
  margin-left: 2em;
}
</style>
