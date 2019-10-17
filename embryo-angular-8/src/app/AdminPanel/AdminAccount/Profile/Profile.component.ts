import { Component, OnInit, Input } from '@angular/core';
import { Profile } from 'src/app/profile';
import { ProfileService } from 'src/app/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './Profile.component.html',
  styleUrls: ['./Profile.component.scss']
})
export class ProfileComponent implements OnInit {

  @Input() profile: Profile;

  constructor(private profileService: ProfileService) { }

  ngOnInit() {
    this.profileService.getClient(2).subscribe(result => {
      this.profile = result;
      return;
    });
  }

}
