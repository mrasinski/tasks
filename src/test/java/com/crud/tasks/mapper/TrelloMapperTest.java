package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.dto.TrelloBoardDto;
import com.crud.tasks.domain.dto.TrelloCardDto;
import com.crud.tasks.domain.dto.TrelloListDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        TrelloListDto listDto1 = new TrelloListDto("1", "First" , false);
        TrelloListDto listDto2 = new TrelloListDto("2", "Second" , true);
        TrelloListDto listDto3 = new TrelloListDto("3", "Third" , true);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(listDto1);
        trelloListDtos.add(listDto2);
        trelloListDtos.add(listDto3);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "First", trelloListDtos);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "Second", trelloListDtos);
        TrelloBoardDto trelloBoardDto3 = new TrelloBoardDto("3", "Third", trelloListDtos);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto1);
        trelloBoardDtos.add(trelloBoardDto2);
        trelloBoardDtos.add(trelloBoardDto3);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals(3, trelloBoards.size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList list1 = new TrelloList("1", "First" , false);
        TrelloList list2 = new TrelloList("2", "Second" , true);
        TrelloList list3 = new TrelloList("3", "Third" , true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(list1);
        trelloLists.add(list2);
        trelloLists.add(list3);
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "First", trelloLists);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "Second", trelloLists);
        TrelloBoard trelloBoard3 = new TrelloBoard("3", "Third", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);
        trelloBoards.add(trelloBoard3);

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(3, trelloBoardDtos.size());
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto listDto1 = new TrelloListDto("1", "First" , false);
        TrelloListDto listDto2 = new TrelloListDto("2", "Second" , true);
        TrelloListDto listDto3 = new TrelloListDto("3", "Third" , true);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(listDto1);
        trelloListDtos.add(listDto2);
        trelloListDtos.add(listDto3);

        //When
        List<TrelloList> mappedList = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertEquals(3, mappedList.size());
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList list1 = new TrelloList("1", "First" , false);
        TrelloList list2 = new TrelloList("2", "Second" , true);
        TrelloList list3 = new TrelloList("3", "Third" , true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(list1);
        trelloLists.add(list2);
        trelloLists.add(list3);

        //When
        List<TrelloListDto> mappedList = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(3, mappedList.size());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("First", "Card1", "first", "1234");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("First", trelloCardDto.getName());
        assertEquals("Card1", trelloCardDto.getDescription());
        assertEquals("first", trelloCardDto.getPos());
        assertEquals("1234", trelloCardDto.getIdList());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("First", "Card1", "first", "1234");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("First", trelloCard.getName());
        assertEquals("Card1", trelloCard.getDescription());
        assertEquals("first", trelloCard.getPos());
        assertEquals("1234", trelloCard.getIdList());
    }
}