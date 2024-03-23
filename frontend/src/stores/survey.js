import { defineStore } from 'pinia';

export const identificationStore = defineStore('form', {
  state: () => ({
    identification_form : {
        p1q1: "",
        p1q2: "",
        p1q3: [],
        p1q4: "",
        p1q5: "",
        p1q6: [],
        p1q7: [],
        p1q8: "",
        p1q9: [],
        p1q10: "",
        p1q11: [],
        p1q12: "",
        p1q13: [],
        p1q14: "",
        p1q15: "",
        p1q16: "",
        p1q17: [],
        p1q18: [],
        p1q19: "",
    }
  }),
  actions: {
    updateForm(fieldName, value) {
      this[fieldName] = value;
    },
    resetForm() {
      Object.keys(this.$state).forEach(key => {
        this[key] = '';
      });
    }
  }
});