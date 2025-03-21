class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> supply = new HashSet<>(Arrays.asList(supplies)); 
        List<String> result = new ArrayList<>();
        HashSet<String> recipe = new HashSet<>(Arrays.asList(recipes));

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], ingredients.get(i));
        }

        while (true) {
            List<String> toRemove = new ArrayList<>();
            boolean changes = false;
            
            for (String val : recipe) {
                boolean avail = true;
                for (String ingri : map.get(val)) {
                    if (!supply.contains(ingri)) {
                        avail = false;
                        break;
                    }
                }
                if (avail) {
                    supply.add(val);
                    result.add(val);
                    toRemove.add(val);
                    changes = true;
                }
            }

            recipe.removeAll(toRemove);
            if (!changes) break;
        }
        return result;
    }
}
