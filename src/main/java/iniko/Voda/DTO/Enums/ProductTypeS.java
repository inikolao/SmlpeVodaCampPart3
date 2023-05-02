package iniko.Voda.DTO.Enums;

public enum ProductTypeS {
    Men
            {
                @Override
                public String toString() {
                    return "Men";
                }
            },
    Women{
        @Override
        public String toString() {
            return "Women";
        }
    },
    Kids{
        @Override
        public String toString() {
            return "Kids";
        }
    },
    Special{
        @Override
        public String toString() {
            return "Special";
        }
    },
}
