'''
	 Question: Given a path to a directory, archive files older
	 than a month, and which can be run on 1st of every month
	 using cron job.
	 Input: directory_path days(optional)
'''
import os

class ArchiveFile(object):
	def __init__(self, directory_path, time_in_days):
		self.directory_path = directory_path
		self.time_in_days = time_in_days
		self.file_list = []
		self.sub_dir = []

	def get_directory(self):
		return self.directory_path

	def get_time(self):
		return self.time_in_days

	def check_for_valid_directory(self, directory_path):
		pass

	def check_for_valid_time(self, time_in_days):
		pass

	def get_creation_time(self, file_name):
		pass

	def move_to_archives(self):
		

	def get_sub_directories(self, directory):
		for val in os.walk(directory):
			for v in val[1]:
				self.sub_dir.append(val[0] + "/" + v)


	def get_list_of_files(self, directory_path):
		self.get_sub_directories(directory_path)
		self.sub_dir.append(directory_path)
		for directory in self.sub_dir:
			for files in os.walk(directory):
				for f in files[2]:
					self.file_list.append(f)
		
if __name__ == '__main__':
	directory_path = raw_input("Enter the directory to archive: ")
	time_in_days = raw_input("Enter the time(in days) threshold more than which files to be archived: ")
	archive_control = ArchiveFile(directory_path, time_in_days)
	archive_control.get_list_of_files(directory_path)
	print archive_control.sub_dir
	print archive_control.file_list
