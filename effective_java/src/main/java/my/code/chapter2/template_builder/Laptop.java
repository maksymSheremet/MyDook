package my.code.chapter2.template_builder;

/**
 * Створи клас Laptop, який має такі параметри:
 * brand – марка (обов’язковий параметр)
 * model – модель (обов’язковий параметр)
 * processor – процесор
 * ram – оперативна пам’ять
 * storage – накопичувач
 * graphicsCard – відеокарта
 * screenSize – розмір екрану
 * batteryCapacity – ємність батареї
 * 📌 Вимоги:
 * Використай Builder Pattern для створення Laptop.
 * Обов’язкові параметри: brand і model.
 * Решта параметрів – необов’язкові.
 * Створи тестовий клас LaptopTest, щоб перевірити:
 * Чи правильно створюється об’єкт Laptop через Builder.
 * Чи можна створити Laptop лише з brand і model.
 * Чи викидається помилка, якщо brand або model – null.
 */
public class Laptop {
    private final String brand;
    private final String model;
    private final String processor;
    private final int ram;
    private final int storage;
    private final String graphicsCard;
    private final double screenSize;
    private final int batteryCapacity;

    private Laptop(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.screenSize = builder.screenSize;
        this.batteryCapacity = builder.batteryCapacity;
    }

    public static class Builder {
        private final String brand;
        private final String model;
        private String processor;
        private int ram;
        private int storage;
        private String graphicsCard;
        private double screenSize;
        private int batteryCapacity;

        public Builder(String brand, String model) {
            if (brand == null || model == null) {
                throw new IllegalArgumentException("Brand and model cannot be null");
            }
            this.brand = brand;
            this.model = model;
        }

        public Builder processor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder ram(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder storage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder screenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public Builder batteryCapacity(int batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
            return this;
        }

        public Laptop build() {
            return new Laptop(this);
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String toString() {
        return String.format("""
            📘 Laptop:
                Brand           : %s
                Model           : %s
                Processor       : %s
                RAM             : %d GB
                Storage         : %d GB
                Graphics Card   : %s
                Screen Size     : %.1f"
                Battery Capacity: %d mAh
            """,
                brand,
                model,
                processor,
                ram,
                storage,
                graphicsCard != null ? graphicsCard : "None",
                screenSize,
                batteryCapacity
        );
    }
}

