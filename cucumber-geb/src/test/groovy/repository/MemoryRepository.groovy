package repository


class MemoryRepository {

   private def map = [:]

   def add(key, value){
     map.put(key, value)
   }

   def get(key){
     map[key]
   }

   def remove(key){
     map.remove(key)
   }

   def clear(){
     map=[:]
   }

   public String toString(){
     map
   }
}
