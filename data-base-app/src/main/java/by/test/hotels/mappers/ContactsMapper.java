package by.test.hotels.mappers;

import by.test.hotels.dto.ContactsDto;
import by.test.hotels.models.Contacts;
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
