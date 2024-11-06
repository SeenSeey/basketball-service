//package com.example.demo;
//
//import com.example.demo.models.Team;
//import com.example.demo.repositories.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//
//public class ConsoleRunner implements CommandLineRunner {
//    private TeamRepository teamRepository;
//    private ContractRepository contractRepository;
//    private GameRepository gameRepository;
//    private PlayerRepository playerRepository;
//    private PerformanceRepository performanceRepository;
//
//    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//    @Autowired
//    public ConsoleRunner(TeamRepository teamRepository, ContractRepository contractRepository,
//                         GameRepository gameRepository, PlayerRepository playerRepository,
//                         PerformanceRepository performanceRepository) {
//        this.teamRepository = teamRepository;
//        this.contractRepository = contractRepository;
//        this.gameRepository = gameRepository;
//        this.playerRepository = playerRepository;
//        this.performanceRepository = performanceRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        this.addTeam();
//    }
//
//    private void addTeam() throws IOException {
//        System.out.println("Enter team details in format: name / conference / wins / looses");
////        Scanner scanner = new Scanner(System.in);
//        String[] params = bufferedReader.readLine().split(" ");
//
//        Team team = new Team(params[0], params[1], Integer.parseInt(params[2]), Integer.parseInt(params[3]));
//
//        teamRepository.save(team);
//    }
//
//    private void addPlayer() {
//
//    }
//
//    private void addContract() {
//
//    }
//}
