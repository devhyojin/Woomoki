import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";
import UserStore from "@/store/modules/UserStore.js";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    UserStore: UserStore,
  },
  plugins: [
    createPersistedState({
      // 여기다 놓은 모듈들의 store값들은 localstorage에 저장됨 == 새로고침해도 날라가지 않음
      paths: ['UserStore'],
    })
  ]
})

// export default store;

