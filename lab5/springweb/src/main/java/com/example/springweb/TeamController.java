package com.example.springweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository; // Внедрение зависимости

    @GetMapping("/teams")
    public Iterable<Team> getTeams() {
        return teamRepository.findAll(); // Возвращаем все команды из БД
    }
		@GetMapping("/teams/{id}")
		public Team getTeam(@PathVariable Long id) {
    		return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
		}
		@PostMapping("/teams")
		public Team createTeam(@RequestBody Team team) {
    		return teamRepository.save(team);
		}
@PutMapping("/teams/{id}")
public Team updateTeam(@PathVariable Long id, @RequestBody Team team) {
    // Проверяем, существует ли команда с данным id
    Team existingTeam = teamRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Team not found"));
    
    // Обновляем поля команды
    existingTeam.setName(team.getName());
    existingTeam.setLocation(team.getLocation());
    existingTeam.setMascot(team.getMascot());
    
    // Сохраняем обновленную команду
    return teamRepository.save(existingTeam);
}
@DeleteMapping("/teams/{id}")
public void deleteTeam(@PathVariable Long id) {
    // Проверяем, существует ли команда с данным id
    Team existingTeam = teamRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Team not found"));
    
    // Удаляем команду
    teamRepository.delete(existingTeam);
}



}
