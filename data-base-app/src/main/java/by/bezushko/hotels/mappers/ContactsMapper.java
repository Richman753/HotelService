package by.bezushko.hotels.mappers;

import by.bezushko.hotels.dto.ContactsDto;
import by.bezushko.hotels.models.Contacts;
import org.springframework.stereotype.Service;

@Service
public class ContactsMapper {
    public ContactsDto toDto(Contacts contacts)
    {
        return new ContactsDto(
                contacts.getPhone(),
                contacts.getEmail()
        );
    }

    public Contacts toEntity(ContactsDto contactsDto)
    {
        return new Contacts(
                0,
                contactsDto.getPhone(),
                contactsDto.getEmail()
        );
    }
}
