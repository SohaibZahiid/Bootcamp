import Recipe from "../components/Recipe";
import '../styles/Home.css'

function Home() {
  return (
    <>
      <div>Home</div>
      <div className="recipe-container">
        <Recipe />
        <Recipe />
        <Recipe />
        <Recipe />
      </div>
    </>
  );
}

export default Home;
