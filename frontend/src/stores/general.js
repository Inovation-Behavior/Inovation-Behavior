import { defineStore } from 'pinia'

export const useGeneralStore = defineStore('general', {
  state: () => ({
    searchQuery: '',
    changeLanguage: true
  }),
//   persist: true,
})
