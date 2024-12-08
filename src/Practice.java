import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Practice {
    private static final String mapLink = "https://recyclemap.kz/";
    public static final List<RecyclableMaterial> materials = getMaterials();
    public static final Map<MaterialType, String> containers = getContainers();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();

        String commandValue = scanner.nextLine();

        switch (commandValue.toLowerCase()) {
            case "map":
                System.out.println("Ссылка на карту: " + mapLink);
                break;
            case "recyclability":
                System.out.print("Введите код переработки: ");
                int code = scanner.nextInt();
                isRecycled(code);
                break;
            case "bonus":
                System.out.print("Введите количество вторсырья, кг: ");
                double weight = scanner.nextDouble();
                int coefficient = (weight < 10) ? 10 : 15;
                double bonusPoints = weight * coefficient;
                System.out.println("Количество бонусных баллов: " + bonusPoints + ".");
                break;
            default:
                System.out.println("Неизвестная команда.");
                break;
        }

        scanner.close();
    }

    public static void isRecycled(int code) {
        for (RecyclableMaterial material : materials) {
            if (material.getCode() == code) {
                System.out.print("Это " + material.getDescription() + ". ");
                if (material.isRecyclable()) {
                    System.out.println("Положите его в контейнер с типом «" + containers.get(material.getMaterialType()) + "».");
                } else {
                    System.out.println("Он не подходит для вторичной переработки.");
                }
                return;
            }
        }
        System.out.println("Материал с таким кодом не найден.");
    }

    public static Map<MaterialType, String> getContainers() {
        Map<MaterialType, String> containers = new HashMap<>();
        containers.put(MaterialType.PLASTIC, "Пластик");
        containers.put(MaterialType.METAL, "Металл");
        containers.put(MaterialType.GLASS, "Стекло");
        containers.put(MaterialType.PAPER, "Бумага");
        containers.put(MaterialType.UNSORTED_WASTE, "Общий мусор");

        return containers;
    }

    public static void printMenu() {
        System.out.println("Введите одну из команд: ");
        System.out.println("map - посмотреть карту с пунктами приёма вторсырья.");
        System.out.println("recyclability - проверить по коду на упаковке, подходит ли материал для переработки.");
        System.out.println("bonus - рассчитать количество бонусных баллов.");
    }

    public static List<RecyclableMaterial> getMaterials() {
        List<RecyclableMaterial> materials = new ArrayList<>();

        materials.add(new RecyclableMaterial(1, MaterialType.PLASTIC, true, "полиэтилентерфталат"));
        materials.add(new RecyclableMaterial(2, MaterialType.PLASTIC, true, "полиэтилен высокой плотности"));
        materials.add(new RecyclableMaterial(3, MaterialType.PLASTIC, false, "поливинилхлорид"));
        materials.add(new RecyclableMaterial(4, MaterialType.PLASTIC, true, "полиэтилен низкой плотности"));
        materials.add(new RecyclableMaterial(5, MaterialType.PLASTIC, true, "полипропилен"));
        materials.add(new RecyclableMaterial(6, MaterialType.PLASTIC, false, "полистирол"));
        materials.add(new RecyclableMaterial(7, MaterialType.PLASTIC, false, "другие виды пластика"));
        materials.add(new RecyclableMaterial(20, MaterialType.PAPER, true, "гофрированный картон"));
        materials.add(new RecyclableMaterial(21, MaterialType.PAPER, true, "прочий картон"));
        materials.add(new RecyclableMaterial(22, MaterialType.PAPER, true, "бумага"));
        materials.add(new RecyclableMaterial(
                23, MaterialType.PAPER, false, "полиграфический картон (открытки, обложки книг и т.д.)"));
        materials.add(new RecyclableMaterial(40, MaterialType.METAL, true, "железо"));
        materials.add(new RecyclableMaterial(41, MaterialType.METAL, true, "алюминий"));
        materials.add(new RecyclableMaterial(70, MaterialType.GLASS, true, "бесцветное стекло"));
        materials.add(new RecyclableMaterial(71, MaterialType.GLASS, true, "зеленое стекло"));
        materials.add(new RecyclableMaterial(72, MaterialType.GLASS, true, "коричневое стекло"));
        materials.add(new RecyclableMaterial(73, MaterialType.GLASS, true, "бутылочное стекло (тёмно-коричневое)"));
        materials.add(new RecyclableMaterial(74, MaterialType.GLASS, true, "бутылочное стекло (светло-коричневое)"));
        materials.add(new RecyclableMaterial(75, MaterialType.GLASS, false, "стекло с малым содержанием свинца"));
        materials.add(new RecyclableMaterial(76, MaterialType.GLASS, false, "хрусталь"));
        materials.add(new RecyclableMaterial(
                77, MaterialType.GLASS, false, "стекло, покрытое медью (электроника, часы)"));
        materials.add(new RecyclableMaterial(
                78, MaterialType.GLASS, false, "стекло, покрытое серебром (зеркало, посуда для сервировки)"));
        materials.add(new RecyclableMaterial(
                79, MaterialType.GLASS, false, "позолоченное стекло (посуда для сервировки)"));

        return materials;
    }
}