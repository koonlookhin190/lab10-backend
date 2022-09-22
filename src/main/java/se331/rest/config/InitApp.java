package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.rest.entity.Event;
import se331.rest.entity.Organizer;
import se331.rest.entity.Participant;
import se331.rest.repository.EventRepository;
import se331.rest.repository.OrganizerRepository;
import se331.rest.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;

    @Autowired
    ParticipantRepository participantRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
       // eventRepository.save(Event.builder()
        Organizer org1,org2,org3;
        org1 = organizerRepository.save(Organizer.builder()
                        .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                        .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                        .name("ChiangMai").build());
        Participant pati1,pati2,pati3,pati4,pati5;
        List<Event> eventList ;
        pati1 = participantRepository.save(Participant.builder()
                .name("Hin1")
                .telNo("001")
                .build());
        pati2 = participantRepository.save(Participant.builder()
                .name("Hin2")
                .telNo("002")
                .build());
        pati3 = participantRepository.save(Participant.builder()
                .name("Hin3")
                .telNo("003")
                .build());
        pati4 = participantRepository.save(Participant.builder()
                .name("Hin4")
                .telNo("004")
                .build());
        pati5 = participantRepository.save(Participant.builder()
                .name("Hin5")
                .telNo("005")
                .build());

        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        eventList = new ArrayList<>();
        eventList.add(tempEvent);
        pati1.setEventHistory(eventList);
        //eventRepository.save(Event.builder()
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);


        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        //eventRepository.save(Event.builder()
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);


        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());

        //eventRepository.save(Event.builder()
        tempEvent.setOrganizer(org2);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());

        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);

    }
}
