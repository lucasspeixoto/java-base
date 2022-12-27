package concepts;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Dates {

    public static void main(String[] args) {

        duration();
    }

    private static void duration() {
        LocalDate d04 = LocalDate.parse("2022-04-10");
        LocalDateTime d05 = LocalDateTime.parse("2022-04-10T01:30:26");
        Instant d06 = Instant.parse("2022-04-10T01:30:26Z");

        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nextWeekLocalDate = d04.plusDays(7);

        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);
        LocalDateTime next2HoursLocalDateTime = d05.plusHours(2);

        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);

        Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
        Duration t2 = Duration.between(pastWeekLocalDateTime, d05);
        Duration t3 = Duration.between(pastWeekInstant, d06);

        System.out.println("Past Week LocalDate = " + pastWeekLocalDate); //? Past Week LocalDate = 2022-04-03
        System.out.println("Next Week LocalDate = " + nextWeekLocalDate); //? Next Week LocalDate = 2022-04-17

        System.out.println("Past Week LocalDateTime = " + pastWeekLocalDateTime); //? Past Week LocalDateTime = 2022-04-03T01:30:26
        System.out.println("Next Week LocalDateTime = " + nextWeekLocalDateTime); //? Next Week LocalDateTime = 2022-04-17T01:30:26
        System.out.println("Next 2 Hours LocalDateTime = " + next2HoursLocalDateTime); //? Next 2 Hours LocalDateTime = 2022-04-10T03:30:26

        System.out.println("Past Week Instant = " + pastWeekInstant); //? Past Week Instant = 2022-04-03T01:30:26Z

        System.out.println("t1 = " + t1.toDays()); //? t1 = 7
        System.out.println("t2 = " + t2.toDays()); //? t2 = 7
        System.out.println("t3 = " + t3.toDays()); //? t3 = 7
    }

    private static void zoneIds() {
        LocalDate d04 = LocalDate.parse("2022-04-10");
        LocalDateTime d05 = LocalDateTime.parse("2022-04-10T01:30:26");
        Instant d06 = Instant.parse("2022-04-10T01:30:26Z");

        for (String s: ZoneId.getAvailableZoneIds()) {
            System.out.println(s);
        }

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));

        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1); //? r1 = 2022-04-09
        System.out.println("r2 = " + r2); //? r2 = 2022-04-10

        System.out.println("r3 = " + r3); //? r3 = 2022-04-09T22:30:26
        System.out.println("r4 = " + r4); //? r4 = 2022-04-10T02:30:26

        System.out.println("d05 dia = " + d05.getDayOfMonth()); //? d05 dia = 10
        System.out.println("d05 mês = " + d05.getMonthValue()); //? d05 mês = 4
        System.out.println("d05 ano = " + d05.getYear()); //? d05 ano = 2022
        System.out.println("d05 hora = " + d05.getHour()); //? 05 hora = 1
    }

    private static void formatters() {
        LocalDate d04 = LocalDate.parse("2022-12-25");
        LocalDateTime d05 = LocalDateTime.parse("2022-12-25T01:30:26");
        Instant d06 = Instant.parse("2022-12-25T10:30:26Z");

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;

        System.out.println("d04 = " + d04.format(fmt1)); //? d04 = 25/12/2022
        System.out.println("d04 = " + fmt1.format(d04)); //? d04 = 25/12/2022
        System.out.println("d05 = " + d05.format(fmt1)); //? d05 = 25/12/2022
        System.out.println("d05 = " + d05.format(fmt2)); //? d05 = 25/12/2022 01:30

        /*
          Quando se trabalha com Instant, é necessário especificar
          o fuso horário para formatação
         */
        System.out.println("d06 = " + fmt3.format(d06)); //? d06 = 25/12/2022 07:30

        System.out.println("d05 = " + d05.format(fmt4)); //? d05 = 2022-12-25T01:30:26

        System.out.println("d06 = " + fmt5.format(d06)); //? d06 = 2022-12-25T10:30:26Z
    }

    private static void options() {
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();
        LocalDate d04 = LocalDate.parse("2022-12-25");
        LocalDateTime d05 = LocalDateTime.parse("2022-12-25T01:30:26");
        Instant d06 = Instant.parse("2022-12-25T01:30:26Z");
        Instant d07 = Instant.parse("2022-12-25T01:30:26-03:00");

        LocalDate d08 = LocalDate.parse("25/12/2022", fmt1);
        LocalDateTime d09 = LocalDateTime.parse("25/12/2022 01:30", fmt2);

        LocalDate d10 = LocalDate.of(2022, 12, 25);
        LocalDateTime d11 = LocalDateTime.of(2022, 12, 25, 1, 30);

        System.out.println("d01 = " + d01); //? d01 = 2022-12-25 Implicitamente estamos o Java faz d01.toString()
        System.out.println("d02 = " + d02); //? d02 = 2022-12-25T15:14:53.722942800
        System.out.println("d03 = " + d03); //? d03 = 2022-12-25T18:14:53.722942800Z
        System.out.println("d04 = " + d04); //? d04 = 2022-12-25
        System.out.println("d05 = " + d05); //? d05 = 2022-12-25T01:30:26
        System.out.println("d06 = " + d06); //? d06 = 2022-12-25T01:30:26Z
        System.out.println("d07 = " + d07); //? d07 = 2022-12-25T04:30:26Z
        System.out.println("d08 = " + d08); //? d08 = 2022-12-25
        System.out.println("d09 = " + d09); //? d09 = 2022-12-25T01:30
        System.out.println("d10 = " + d10); //? d10 = 2022-12-25
        System.out.println("d11 = " + d11); //? d11
    }
}
