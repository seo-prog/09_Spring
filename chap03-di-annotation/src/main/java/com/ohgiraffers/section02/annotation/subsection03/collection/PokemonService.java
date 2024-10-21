package com.ohgiraffers.section02.annotation.subsection03.collection;


import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceCollection")
public class PokemonService {

    @Autowired
    private List<Pokemon> pokemonList; // 이런식으로 autowired 로 하게 되면은 객체를 list 로 만들어서 주입할것이다.

    public void pokemonAttack(){
        for(Pokemon pokemon : pokemonList){
            pokemon.attack();
        }
    }

}
