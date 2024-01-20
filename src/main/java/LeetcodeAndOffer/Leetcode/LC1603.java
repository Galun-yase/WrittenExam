package LeetcodeAndOffer.Leetcode;

public class LC1603 {

    class ParkingSystem {

        private int big = 0;
        private int medium = 0;
        private int small = 0;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1) {
                if (big == 0) return false;
                big--;
            } else if (carType == 2) {
                if (medium == 0) return false;
                medium--;
            } else if (carType == 3) {
                if (small == 0) return false;
                small--;
            }
            return true;
        }
    }

    class ParkingSystem_2 {

        int bigCap;
        int medCap;
        int smaCap;

        public ParkingSystem_2(int big, int medium, int small) {
            bigCap = big;
            medCap = medium;
            smaCap = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:
                    if (bigCap > 0) {
                        bigCap--;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (medCap > 0) {
                        medCap--;
                        return true;
                    } else {
                        return false;
                    }
                case 3:
                    if (smaCap > 0) {
                        smaCap--;
                        return true;
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
        }
    }
}
