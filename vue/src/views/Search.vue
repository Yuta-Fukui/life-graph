<template>
  <div id="search">
    <SearchIput />
    <SearchResults />
  </div>
</template>

<script>
import SearchIput from './components/SearchIput.vue'
import SearchResults from './components/SearchResults.vue'

export default {
  name: 'Search',
  components: {
    SearchIput,
    SearchResults
  }
}
</script>
