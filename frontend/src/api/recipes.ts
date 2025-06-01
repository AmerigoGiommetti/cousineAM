export async function fetchRecipes() {
  const response = await fetch('http://localhost:8080/api/recipes');
  if (!response.ok) {
    throw new Error('Network response was not ok');
  }
  return response.json();
}
