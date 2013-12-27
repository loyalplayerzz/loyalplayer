
    create table `mysql`.`ALGORITHM`(
        `id` INT not null auto_increment,
       `param_table` VARCHAR(100),
       `description` VARCHAR(100),
        primary key (`id`)
    );

    create unique index `PRIMARY` on `mysql`.`ALGORITHM`(`id`);

 create table `mysql`.`ALGO_TOTALBETONPROVIDER`(
        `id` INT not null auto_increment,
       `provider_id` VARCHAR(100),
       `bet_amt` INT,
       `no_of_days` INT,
        primary key (`id`)
    );

    create unique index `PRIMARY` on `mysql`.`ALGO_TOTALBETONPROVIDER`(`id`);


    create table `mysql`.`ALGO_TOTALROUNDSONGAME`(
        `badge_id` INT not null,
       `no_of_rounds` INT,
       `bet_amt` INT,
       `eligible_games` VARCHAR(100),
        primary key (`badge_id`)
    );

    create unique index `PRIMARY` on `mysql`.`ALGO_TOTALROUNDSONGAME`(`badge_id`);


    create table `mysql`.`BADGE_DETAILS`(
        `id` INT not null auto_increment,
       `badge_name` VARCHAR(15),
       `badge_description` VARCHAR(100),
       `description` VARCHAR(100),
       `algo_id` INT,
       `active` BIT,
       `image` VARCHAR(100),
        primary key (`id`)
    );

    create unique index `PRIMARY` on `mysql`.`BADGE_DETAILS`(`id`);


    create table `mysql`.`BADGE_LOYALGIFT`(
        `id` INT not null auto_increment,
       `badge_id` INT not null,
       `loyal_gift_id` INT not null,
        primary key (`id`)
    );

    create unique index `PRIMARY` on `mysql`.`BADGE_LOYALGIFT`(`id`);
    create index `badge_id` on `mysql`.`BADGE_LOYALGIFT`(`badge_id`);
    create index `loyal_gift_id` on `mysql`.`BADGE_LOYALGIFT`(`loyal_gift_id`);


    create table `mysql`.`LEVEL_GIFT`(
        `id` INT not null auto_increment,
       `level_id` INT not null,
       `gift_id` INT not null,
        primary key (`id`)
    );

    create unique index `PRIMARY` on `mysql`.`LEVEL_GIFT`(`id`);
    create index `gift_id` on `mysql`.`LEVEL_GIFT`(`gift_id`);
    create index `level_id` on `mysql`.`LEVEL_GIFT`(`level_id`);


    create table `mysql`.`LEVEL`(
        `id` INT not null auto_increment,
       `description_en` VARCHAR(100),
       `description_sv` VARCHAR(100),
       `points` INT,
       `image` VARCHAR(100),
        primary key (`id`)
    );

    create unique index `PRIMARY` on `mysql`.`LEVEL`(`id`);


    create table `mysql`.`LOYALPOINTS`(
        `id` INT not null auto_increment,
       `bet` INT,
       `currency` VARCHAR(20),
       `points` INT,
        primary key (`id`)
    );

    create unique index `LOYALPOINTS` on `mysql`.`LOYALPOINTS`(`id`);
    create unique index `PRIMARY` on `mysql`.`LOYALPOINTS`(`id`);


    create table `mysql`.`LOYAL_GIFTS`(
        `id` INT not null auto_increment,
       `gift_type` VARCHAR(2),
       `name` VARCHAR(100),
       `description` VARCHAR(100),
       `points` INT,
       `image` VARCHAR(100),
        primary key (`id`)
    );

    create unique index `PRIMARY` on `mysql`.`LOYAL_GIFTS`(`id`);

    create table `mysql`.`PROVIDER`(
        `id` INT not null auto_increment,
       `name` VARCHAR(100),
       `description` VARCHAR(100),
       `type` VARCHAR(100),
       `active` BIT,
        primary key (`id`)
    );

    create unique index `PRIMARY` on `mysql`.`PROVIDER`(`id`);

