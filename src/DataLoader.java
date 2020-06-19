import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

public class DataLoader {
    private static String mealsFileName = "Meals.txt";
    private static String cityFileName = "City.txt";
    private static String branchesFileName = "Branches.txt";

    public Vector<Meal> loadMeals(){
        try{
            Vector<Meal> meals = new Vector<Meal>();
            FileReader fileReader = new FileReader(mealsFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            int mealsNumber = Integer.parseInt(line);
            for(int i = 0 ; i < mealsNumber ; i++)
            {
                line = bufferedReader.readLine();
                String tokens[] = line.split("/");
                meals.add(new Meal(tokens[0], Double.parseDouble(tokens[1])));
            }
            return meals;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public Vector<Branch> loadBranches()
    {
        try{
            FileReader fileReader = new FileReader(branchesFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Vector<Branch> branches = new Vector<Branch>();

            String line = bufferedReader.readLine();
            int numberOfBranches = Integer.parseInt(line);

            for(int i = 0 ; i < numberOfBranches ; i++)
            {
                line = bufferedReader.readLine();
                String tokens[] = line.split("/");
                branches.add(new Branch(Integer.parseInt(tokens[0])));
            }
            return branches;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public City loadCity()
    {
        try
        {
            FileReader fileReader = new FileReader(cityFileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            String tokens[] = line.split(" ");
            int numberOfNodes = Integer.parseInt(tokens[0]);
            int numberOfEdges = Integer.parseInt(tokens[1]);
            Vector<Vector<Pair<Integer, Long>>> graph = new Vector<Vector<Pair<Integer, Long>>>();
            for(int i = 0 ; i < numberOfNodes ; i++)
                graph.add(new Vector<>());
            for(int i = 0 ; i < numberOfEdges ; i++)
            {
                line = bufferedReader.readLine();
                tokens = line.split("/");
                int node1 = Integer.parseInt(tokens[0]);
                int node2 = Integer.parseInt(tokens[1]);
                long streetLength = Long.parseLong(tokens[2]);
                graph.elementAt(node1).add(new Pair<>(node2, streetLength));
                graph.elementAt(node2).add(new Pair<>(node1, streetLength));
            }
            return new City(numberOfNodes, graph, loadBranches());
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
