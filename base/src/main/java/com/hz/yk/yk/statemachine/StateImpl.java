package com.hz.yk.yk.statemachine;

/**
 * @author wuzheng.yk
 *         Date: 15/4/29
 *         Time: 16:24
 */
public enum StateImpl implements IState {
    OFF {
        @Override
        void exit(Aircon1 ac) {
            super.exit(ac);
            System.out.print("start Fan");
        }

        @Override
        public void power(Aircon1 ac) {
            this.exit(ac);
            ac.state = FANONLY;
            ac.entry();
        }

        @Override
        public void cool(Aircon1 ac) {
            System.out.println("nothing");
        }
    }, FANONLY {
        @Override
        public void power(Aircon1 ac) {
            this.exit(ac);
            stopFan();
            ac.state = OFF;
            ac.entry();
        }

        @Override
        public void cool(Aircon1 ac) {
            this.exit(ac);
            ac.state = COOL;
            ac.entry();
        }
    },
    COOL {
        @Override
        void exit(Aircon1 ac) {
            super.exit(ac);
            System.out.print("stop Cool");
        }

        @Override
        void entry(Aircon1 ac) {
            System.out.print("start Cool");
            super.entry(ac);
        }

        @Override
        public void power(Aircon1 ac) {
            this.exit(ac);
            stopFan();
            ac.state = OFF;
            ac.entry();
        }

        @Override
        public void cool(Aircon1 ac) {
            this.exit(ac);
            ac.state = FANONLY;
            ac.entry();
        }
    };


    //状态机的各种动作action methode
    void entry(Aircon1 ac) {
        ac.entry();
    }

    void exit(Aircon1 ac) {
        System.out.println(ac.state.name() + "→ ");
    }


    void stopFan() {
        System.out.print("stop Fan");
    }
}
