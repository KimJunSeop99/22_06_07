<template>
  <!-- 기존 회원이 있을 경우 currentCustomer != null -->
  <div v-if="!currentCustomer">
    <!-- mb-3 : m(margin), p(padding), l(left), r(right), b(bottom), 1 : 25px, 2 : 50px -->
    <div class="mb-3">
      <label for="firstName" class="form-label"> FirstName </label>
      <input
        type="text"
        class="form-control"
        id="firstName"
        required
        name="firstName"
        v-model="currentCustomer.firstName"
      />
    </div>
    <div class="mb-3">
      <label for="lastName" class="form-label"> LastName </label>
      <input
        type="text"
        class="form-control"
        id="lastName"
        required
        name="lastName"
        v-model="currentCustomer.lastName"
      />
    </div>
    <div class="mb-3">
      <label for="email" class="form-label"> Email </label>
      <input
        type="text"
        class="form-control"
        id="email"
        required
        name="email"
        v-model="currentCustomer.email"
      />
    </div>
    <div class="mb-3">
      <label for="phone" class="form-label"> Phone </label>
      <input
        type="text"
        class="form-control"
        id="phone"
        required
        name="phone"
        v-model="currentCustomer.phone"
      />
    </div>
    <div class="mb-3">
      <button @click="updateCustomer" class="btn btn-primary me-3">
        Update
      </button>
      <button @click="deleteCustomer" class="btn btn-danger">Delete</button>
    </div>
    <!-- 수정버튼을 클릭 후 성공했을 때 아래가 보임 -->
    <div class="alert alert-success" role="alert" v-if="message">
      {{ message }}
    </div>
  </div>
</template>

<script>
// 화면 설명 : 화면 설정 / 화면 수정
import CustomerDataService from "@/services/CustomerDataService";

export default {
  name: "edit-customer",
  data() {
    return {
      currentCustomer: null,
      message: "",
    };
  },
  methods: {
    // id에 해당하는 회원정보를 조회하는 서비스를 요청(springboot)
    getCustomer(id) {
      // axios 통신이용 서비스 호출(springboot)
      CustomerDataService.get(id)
        // 성공하면 then으로 결과 데이터가 들어옴(response.data )
        .then((response) => {
          this.currentCustomer = response.data;
        })
        // 실패하면 catch로 에러 데이터가 들어옴
        .catch((e) => {
          alert(e);
        });
    },
    // 회원정보 수정 서비스 요청(springboot)
    updateCustomer() {
      // axios 이용해서 회원정보 수정 요청(springboot)
      CustomerDataService.update(this.currentCustomer.id, this.currentCustomer)
        // 성공하면 then에서 message로 데이터를 넣음
        .then(() => {
          this.message = "The customer was updated successfully!";
        })
        // 실패하면 catch로 에러 데이터가 들어옴
        .catch((e) => {
          alert(e);
        });
    },
    // 회원삭제 서비스 요청(springboot)
    deleteCustomer() {
      // axios 이용해서 회원 삭제 요청(springboot)
      CustomerDataService.delete(this.currentCustomer.id)
        // 성공하면 then으로 결과 데이터가 들어옴
        .then(() => {
          // router/index.js 안에 name
          // 화면이동: customers 화면으로 이동됨
          this.$router.push({ name: "customers" });
        })
        // 실패하면 catch로 에러 데이터가 들어옴
        .catch((e) => {
          alert(e);
        });
    },
  },
  // 화면이 뜨면 실행되는 이벤트
  // http://localhost:8080/:id
  // $route : router/index.js , params.id
  mounted() {
    this.getCustomer(this.$route.params.id);
  },
};
</script>

<style>
</style>