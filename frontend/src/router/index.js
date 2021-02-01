import Vue from "vue";
import VueRouter from "vue-router";
import Main from "@/views/MainPage/MainPage.vue";
import Signup from "@/views/Signup/Signup.vue";
import FavoriteCategory from "@/views/Signup/components/FavoriteCategory.vue";
import Login from "@/views/Login/Login.vue";
import FindId from "@/views/Login/components/FindId.vue";
import FindIdResult from "@/views/Login/components/FindIdResult.vue";
import FindPassword from "@/views/Login/components/FindPassword.vue";
import FindPasswordByEmail from "@/views/Login/components/FindPasswordByEmail.vue";
import FindPasswordByPhone from "@/views/Login/components/FindPasswordByPhone.vue";
import FindPasswordResult from "@/views/Login/components/FindPasswordResult.vue";
import UserPage from "@/views/UserPage/UserPage.vue";
import UserPageEdit from "@/views/UserPageEdit/UserPageEdit.vue";
import CompareOriginPassword from "@/views/UserPageEdit/CompareOriginPassword.vue";
import CreateSeed from "@/views/Seed/CreateSeed.vue";
// import KakaoTalk from "@/views/Login/callback/KakaoTalk.vue";
Vue.use(VueRouter);

// Containers
const BlankContainer = () => import('@/containers/BlankContainer')


const routes = [
  {
    path: "/",
    name: "Main",
    component: Main
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup
  },
  {
    path: "/signup/favCategory",
    name: "FavoriteCategory",
    component: FavoriteCategory
  }, 
  {
    path: '/login',
    name: 'Login',
    component: Login,        
  },
  {
    path: '/login/findId',
    name: 'FindId',
    component: FindId,        
  },
  {
    path: '/login/findIdResult',
    name: 'FindIdResult',
    component: FindIdResult,        
  },
  {
    path: '/login/findPassword',
    name: 'FindPassword',
    component: FindPassword,        
  },
  {
    path: '/login/findPasswordByEmail',
    name: 'FindPasswordByEmail',
    component: FindPasswordByEmail,        
  },
  {
    path: '/login/findPasswordByPhone',
    name: 'FindPasswordByPhone',
    component: FindPasswordByPhone,        
  },
  {
    path: '/login/findPasswordResult',
    name: 'FindPasswordResult',
    component: FindPasswordResult,        
  },
  {
    path: '/userPage',
    name: 'UserPage',
    component: UserPage,        
  },
  {
    path: '/userPage/userPageEdit',
    name: 'UserPageEdit',
    component: UserPageEdit,        
  },
  {
    path: '/userPage/password',
    name: 'CompareOriginPassword',
    component: CompareOriginPassword,        
  },
  {
    path: '/callback',
    name: 'callback',
    redirect: '/login',
    component: BlankContainer,
    children: [
      {
        path: 'kakaotalk',
        name: 'callback-kakaotalk',
        component: () => import('@/views/Login/callback/KakaoTalk'),
      },
    ]
  },
  {
    path: '/createSeed',
    name: 'CreateSeed',
    component: CreateSeed,        
  },
  
];
const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;